pipeline {
    agent any 
    tools {
        maven 'Maven 3.8.1'
        jdk 'jdk8'
    }
    stages {
        stage ('Build') {
            steps {    
                sh ' mvn clean install -DskipTests'
            }
        }
        /*stage ('Test') {
            steps {    
                sh ' mvn test'
            }
        }*/
        stage ('Imagem docker') {
            steps {
                sh 'docker build . -t vonex/api_autorizacao:${BUILD_NUMBER}'
            }
        }
        stage ('Run docker') {
            steps {
                /*sh ' docker stop integra' 
                sh ' docker rm integra'*/
                sh ' docker container run -d --name integra-autorizacao -p 8082:8082 vonex/api_autorizacao:${BUILD_NUMBER}'
            }
        }        
    }
}


