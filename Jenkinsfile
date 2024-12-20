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
                            secretValues: [[envKey: 'TEST_PASSWORD', vaultKey: "test_password"]]
                        ]
                    ]

                    def configuration = [
                        vaultCredentialId: 'vault-jenkins-role2',
                        engineVersion: 1
                    ]
                    withVault([configuration: configuration, vaultSecrets: secrets]) {
                        sh 'echo "Vault KV Values"'
                        echo "All secrets: $TEST_PASSWORD"
                    }
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
