<template>
  <div>
    <h1>Document Detail</h1>
    <document-detail v-bind:document="document" />
  </div>
</template>

<script>
import DocumentDetail from '../components/DocumentDetail.vue';
import DocsService from '../services/DocsService';


export default {
  components: {
    DocumentDetail
  },
  data() {
    return {
      document: {}
    };
  },
  created() {
    DocsService
      .get(this.$route.params.id)
      .then(response => {
        this.document = response.data;
      });
  }
};
</script>
