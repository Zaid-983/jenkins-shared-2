def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        def args = '--scan ./' +
                   ' --nvdApiKey ' + NVD_API_KEY +    // ← concatenation not interpolation
                   ' --disableYarnAudit' +
                   ' --disableNodeAudit' +
                   ' --data /var/lib/jenkins/caches/dependency-check' +
                   ' --out ./'

        dependencyCheck(
            additionalArguments: args,
            odcInstallation: 'OWASP'
        )
        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
