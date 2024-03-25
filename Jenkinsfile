

pipeline {
    agent any
    tools{
        maven 'Maven'
    } 
    stages {
        stage('Build-jar') {
            steps {
                script {
                    echo(message: 'build application ')
                    sh 'mvn package'
                }
            }
        } 
            stage('Build image') {
            steps {
                script {
                    echo(message: 'docker image')
                   withCredentials([usernamePassword(credentialsId: 'docker-repo', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                      sh(script: 'docker build -t sahilchaudhari2405/my-repo/:jma-2.1 .') 
                      sh(script: "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}")
                      sh(script: 'docker push sahilchaudhari2405/my-repo/:jma-2.1')
                    } 
                }
            }
        } 
         stage('deploy') {
            steps {
                script {
                    echo(message: 'deploy')
                }
            }
         }

    }
    
    post {
        success {
            // Actions to perform when the pipeline succeeds
            echo 'Pipeline succeeded!'
        }
        failure {
            // Actions to perform when the pipeline fails
            echo 'Pipeline failed!'
        }
    }
}
