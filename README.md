# Bytes
A library for converting bytes to other data types and back.

---

## Snapshot

![version](https://img.shields.io/static/v1?label=version&message=0.2.1-SNAPSHOT&labelColor=212121&color=2962ff&style=flat)

- [Maven](https://s01.oss.sonatype.org/content/repositories/snapshots/com/github/kepocnhh/Bytes/0.2.1-SNAPSHOT)
- [Documentation](https://StanleyProjects.github.io/Bytes/doc/0.2.1-SNAPSHOT)

### Build
```
$ gradle lib:assembleSnapshotJar
```

### Import
```kotlin
repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("com.github.kepocnhh:Bytes:0.2.1-SNAPSHOT")
}
```

---

## Unstable

> GitHub [0.4.0u-SNAPSHOT](https://github.com/StanleyProjects/Bytes/releases/tag/0.4.0u-SNAPSHOT) release
>
> Maven [metadata](https://central.sonatype.com/repository/maven-snapshots/com/github/kepocnhh/Bytes/maven-metadata.xml)

### Build
```
$ gradle lib:assembleUnstableJar
```

### Import
```kotlin
repositories {
    maven("https://central.sonatype.com/repository/maven-snapshots")
}

dependencies {
    implementation("com.github.kepocnhh:Bytes:0.4.0u-SNAPSHOT")
}
```

---
