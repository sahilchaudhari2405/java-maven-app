pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
              echo 'build'
            }
        }
        stage('Test') {
            steps {
                // Your test steps here
               echo 'test'
            }
        }
        stage('Deploy') {
            steps {
               echo 'deploy'
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
