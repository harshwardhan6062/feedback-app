pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/harshwardhan6062/feedback-app.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Build step'
            }
        }

        stage('Test') {
            steps {
                echo 'Run tests here'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
