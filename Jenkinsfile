def gv
pipeline {
    agent any
    parameters {
        string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
    }
    stages {
        stage('init')
        {
            step
            {
                script
                {
                    gv = load(path: 'script.groovy')
                }
            }
        }
        stage('Build package') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                   gv. buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('Login to Docker and Push Image') {
            steps {
                script {
                   gv.loginAndpush(params.IMAGE_VERSION)
                }
            }
        }
        stage('deploy')
        {
            step{
                echo 'deploy'
            }
        }
    }
    post {
        success {
            echo 'Image build and push succeeded!'
        }
        failure {
            echo 'Image build and push failed!'
        }
    }
}
