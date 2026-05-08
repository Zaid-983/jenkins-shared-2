stage("OWASP: Dependency check") {
    steps {
        withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
            dependencyCheck(
                additionalArguments: "--scan ./ --nvdApiKey ${NVD_API_KEY} --disableYarnAudit --disableNodeAudit",
                odcInstallation: 'OWASP'
            )
            dependencyCheckPublisher(
                pattern: '**/dependency-check-report.xml'
            )
        }
    }
}
