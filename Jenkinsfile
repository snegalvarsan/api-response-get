pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    sh 'git clone https://snegalvarsan:github.com/snegalvarsan/api-response-getter.git repo'
                }
            }
        }
        stage('Execute Script') {
            steps {
                script {
                    sh 'cd repo && chmod +x testExecute.sh && ./testExecute.sh'
                }
            }
        }
    }
    post {
        always {
            script {
                sh 'rm -rf repo'
            }
        }
    }
}
