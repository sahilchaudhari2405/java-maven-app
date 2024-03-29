def gv
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    parameters {
        string(defaultValue: '1.0', description: 'Custom version for the image', name: 'IMAGE_VERSION')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('build app') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('build image') {
            when{
                expression
                {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.buildImage(params.IMAGE_VERSION)
                }
            }
        }
        stage('deploy') {
             when{
                expression
                {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    gv.deployApp(params.IMAGE_VERSION)
                }
            }
        }
    }
}
