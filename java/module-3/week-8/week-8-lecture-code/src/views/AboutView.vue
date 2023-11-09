<template>
  <div class="about">
    <h1>About View</h1>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.about {
  padding-top: 20px;
  display: flex;
  justify-content: center;
}

input {
  margin-left: 20px;
}

@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
