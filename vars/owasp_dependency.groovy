
def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        dependencyCheck(
            additionalArguments: '--scan ./ --nvdApiKey $NVD_API_KEY --disableYarnAudit --disableNodeAudit --data /var/lib/jenkins/caches/dependency-check',
            odcInstallation: 'OWASP'
        )
        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
