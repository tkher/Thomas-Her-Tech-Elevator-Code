<template lang="">
  <div>
    <router-link v-bind:to="{name: 'productsDetail', params: {id: productData.productId}}">
    {{ productData }}
    </router-link>
  </div>
</template>

<script>
export default {
  props: ['productData']
}
</script>
<style lang="">
  
</style>