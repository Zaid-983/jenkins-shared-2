// In your shared library — vars/owasp_dependency.groovy
def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        dependencyCheck(
            additionalArguments: """
                --scan ./
                --disableYarnAudit
                --disableNodeAudit
                --nvdApiKey ${NVD_API_KEY}
            """,
            odcInstallation: 'OWASP'
        )
        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
