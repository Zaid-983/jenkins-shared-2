def call(String toolName, String projectName, String projectKey){
    withSonarQubeEnv(toolName) {
        sh """
            export SONAR_SCANNER_OPTS="-Xmx1024m"
            ${SONAR_HOME}/bin/sonar-scanner \
                -Dsonar.projectName=${projectName} \
                -Dsonar.projectKey=${projectKey}
        """
    }
}
