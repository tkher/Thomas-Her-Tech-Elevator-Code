<template>
<best-seller-list></best-seller-list>
<new-releases-list></new-releases-list>

    
</template>

<script>
import BestSellerList from '../components/BestSellerList.vue';
import NewReleasesList from '../components/NewReleasesList.vue';


export default {
    name:'home-view',
    components: {
        BestSellerList,
        NewReleasesList,
    }
}
</script>



<style>

</style>
