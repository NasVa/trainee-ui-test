pipeline {
    agent any
    tools {
        maven '3.9.9'
    }
    stages {
        stage('Setup Environment') {
            steps {
                script{
                    def secrets = [
                        [
                            path: 'secrets/creds/test-creds',
                            engineVersion: 1,
                            secretValues: [[vaultKey: 'testPassword']]
                        ]
                    ]

                    def configuration = [
                        vaultUrl: 'http://vault:8200',
                        vaultCredentialId: 'vault-vagrant',
                        engineVersion: 1
                    ]
                    withVault([configuration: configuration, vaultSecrets: secrets]) {
                        sh 'echo "Vault KV Values"'
                        echo "All secrets: $testPassword"
                    }
                }
            }
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
