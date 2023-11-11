<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <nav>
      <router-link v-bind:to="{ name: 'HomeView' }">Back to Topic List</router-link>
    </nav>
    <topic-details v-bind:topic="topic" />
  </div>
</template>

<script>
import TopicDetails from '../components/TopicDetails.vue';
import TopicService from '../services/TopicService';

export default {
  components: {
    TopicDetails
  },
  data() {
    return {
      topic: {},
      isLoading: true
    }
  },
  methods: {

    getTopic(id) {
      // TODO - Get data from API and set `topics` property
      this.isLoading=true;
    TopicService.getTopic(id)
    .then((response) => {
      this.topic = response.data;
    })
    .catch((error) => {
      this.errorMessage = error.response.statusText;
    })
    .finally(() => {
      this.isLoading = false;
    })
  },
    handleErrorResponse(error) {
      if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.isLoading = false;
          this.$store.commit('SET_NOTIFICATION', `Could not get topic data from server.`);
        }
    }
  },
  created() {
    this.getTopic(this.$route.params.topicId);
  }
};
</script>

<style scoped>
</style>