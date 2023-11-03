<template>
  <footer>
    &copy; 2023. All rights reserved.
  </footer>
</template>

<script>
export default {
  name: 'SiteFooter'
}
</script>

<style scoped>
footer {
  grid-area: footer;
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 0.8rem;
  padding: 0 10px;
  border-top: 2px solid #777;
  background-color: rgb(91, 158, 247);
  color: white;
}
</style>