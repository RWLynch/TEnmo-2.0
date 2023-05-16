<template>
<div class="slideshow">
  <img src="src/assets/slideshow-photos/eugene-chystiakov-cvqvLMVEfBY-unsplash.jpg" alt="Slideshow Image">
  <img src="src/assets/slideshow-photos/shawnanggg-H82HDdkcd4c-unsplash.jpg" alt="Slideshow Image">
  <img src="src/assets/slideshow-photos/joel-muniz-0QuIgOjLLXc-unsplash.jpg" alt="Slideshow Image">
  <img src="src/assets/slideshow-photos/ghen-mar-cuano-R6dSBkz32B8-unsplash.jpg" alt="Slideshow Image">
  <img src="src/assets/slideshow-photos/elevate-UoPNA8I-_p0-unsplash.jpg" alt="Slideshow Image">
  <img src="src/assets/slideshow-photos/drew-beamer-bTN-zKFy9uA-unsplash.jpg" alt="Slideshow Image">
</div>
</template>

<style>
.slideshow {
  position: relative;
  width: 100%;
  height: 500px;
  overflow: hidden;
}

.slideshow img {
  position: absolute;
  top: 0;
  left: 0;
  width: 25%;
  height: 100%;
  opacity: 0;
  animation: fadeAnimation 15s infinite;
}

@keyframes fadeAnimation {
  0% {
    opacity: 0;
  }
  20% {
    opacity: 1;
  }
  80% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}
</style>
