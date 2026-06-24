## Deploy a Render

1. Fix the Dockerfile so Render builds the JAR inside the image instead of copying a local `target/` artifact.
2. Switch runtime config to environment variables with safe local defaults.
3. Verify the project builds and the Dockerfile no longer depends on prebuilt files.
