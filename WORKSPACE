workspace(name = "com_github_mate_matcher")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_java",
    sha256 = "f8ae9ed3887df02f40de9f4f7ac3873e6dd7a471f9cddf63952538b94b59aeb3",
    urls = [
        "https://github.com/bazelbuild/rules_java/releases/download/7.6.1/rules_java-7.6.1.tar.gz",
    ],
)

load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")

rules_java_dependencies()

rules_java_toolchains()

# ------------------------------------------------
# Java support for generating dependencies based on Maven artifacts.
#
# See https://github.com/bazelbuild/rules_jvm_external

RULES_JVM_EXTERNAL_TAG = "6.1"

RULES_JVM_EXTERNAL_SHA = "08ea921df02ffe9924123b0686dc04fd0ff875710bfadb7ad42badb931b0fd50"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")
# load("@rules_jvm_external//:specs.bzl", "maven")

http_archive(
    name = "contrib_rules_jvm",
    sha256 = "e6cd8f54b7491fb3caea1e78c2c740b88c73c7a43150ec8a826ae347cc332fc7",
    strip_prefix = "rules_jvm-0.27.0",
    url = "https://github.com/bazel-contrib/rules_jvm/releases/download/v0.27.0/rules_jvm-v0.27.0.tar.gz",
)

# Fetches the contrib_rules_jvm dependencies.
# If you want to have a different version of some dependency,
# you should fetch it *before* calling this.
load("@contrib_rules_jvm//:repositories.bzl", "contrib_rules_jvm_deps")

contrib_rules_jvm_deps()

# Now ensure that the downloaded deps are properly configured
load("@contrib_rules_jvm//:setup.bzl", "contrib_rules_jvm_setup")

contrib_rules_jvm_setup()

maven_install(
    artifacts = [
        "com.google.guava:guava:32.1.3-jre",
        "org.eclipse.jetty:jetty-server:10.0.13",
        "org.eclipse.jetty:jetty-servlet:10.0.13",
        "org.eclipse.jetty:jetty-servlets:10.0.13",
        "org.eclipse.jetty:jetty-util:10.0.13",
        "org.apache.httpcomponents:httpclient:4.5.13",
    ],
    excluded_artifacts = [
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://maven.google.com",
        "http://packages.confluent.io/maven/",  # Beam requires this for confluent kafka avro serializer packages
        # The static URL repository below is required for the Amazon Codeguru Profiler Java Agent
        # https://docs.aws.amazon.com/codeguru/latest/profiler-ug/enabling-the-agent-with-code.html
        "https://d1osg35nybn3tt.cloudfront.net",
        "https://jcenter.bintray.com",  # required by some packages like com.google.android:flexbox:1.0.0
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
