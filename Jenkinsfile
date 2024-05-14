pipeline {
    agent any
    tools {
        maven "maven3"
        jdk "OpenJdk17"
    }

    stages {
        stage('Fetch code') {
            steps {
               git branch: 'main', url: 'https://github.com/kloudblogs/student-management.git'
            }

        }

        stage('Build'){
            steps{
               sh 'mvn install -DskipTests'
            }

            post {
               success {
                  echo 'Now Archiving it...'
                  archiveArtifacts artifacts: '**/target/*.war'
               }
            }
        }

        stage('UNIT TEST') {
            steps{
                sh 'mvn test'
            }
        }

         stage('Checkstyle Analysis'){
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }

         stage('Sonar Analysis') {
            environment {
                scannerHome = tool 'sonar5'
            }
            steps {
               withSonarQubeEnv('sonar') {
                   sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=student-management \
                   -Dsonar.projectName=student-management \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/ \
                   -Dsonar.java.binaries=target/test-classes/com/sms/ \
                   -Dsonar.junit.reportsPath=target/surefire-reports/ \
                   -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                   -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml'''
              }
            }
         
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage("UploadArtifact"){
            steps{
                nexusArtifactUploader(
                  nexusVersion: 'nexus3',
                  protocol: 'http',
                  nexusUrl: '172.31.56.12:8081',
                  groupId: 'QA',
                  version: "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}",
                  repository: 'student-management-repo',
                  credentialsId: 'nexus-login',
                  artifacts: [
                    [artifactId: 'student-management',
                     classifier: '',
                     file: 'target/student-management-0.0.1-SNAPSHOT.war',
                     type: 'war']
    ]
 )
            }
        }


    }
}
