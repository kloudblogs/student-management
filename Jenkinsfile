pipeline {
	agent any
	tools {
	    maven "maven3"
	    jdk "OpenJdk11"
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
	}
}