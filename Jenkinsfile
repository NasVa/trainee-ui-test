pipeline {
    agent any
    tools {
        maven '3.9.9'
    }
    stages {
        stage('Test') {
            steps {
                script {
                    try{
                        sh 'mvn clean test'
                    }
                    catch (err) {
                        echo "Failed: ${err}"
                    }
                }
            }
        }
        stage('Allure Report Generation') {
            steps {
                allure includeProperties:
                     false,
                     jdk: '',
                     results: [[path: 'target/allure-results']]
            }
        }
    }
}
