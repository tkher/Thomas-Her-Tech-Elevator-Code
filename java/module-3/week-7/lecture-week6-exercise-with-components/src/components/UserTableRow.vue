<template>
  <tr>
  <td>
    <input type="checkbox"
           v-bind:id="user.id"
           v-bind:value="user.id"
           v-bind:checked="isChecked"
           v-on:change="onCheck(user.id)" />
  </td>
  <td>{{ user.firstName }}</td>
  <td>{{ user.lastName }}</td>
  <td>{{ user.username }}</td>
  <td>{{ user.emailAddress }}</td>
  <td>{{ user.status }}</td>
  <td>
    <button class="btnActivateDeactivate" v-on:click="flipStatus(user.id)">{{ user.status === 'Active' ? 'Deactivate' :
      'Activate' }}</button>
  </td>
</tr>
</template>

<script>
export default {
  props: ['user'],
  data(){
    return {

    }
  },
  computed: {
    isChecked(){
      return this.$store.state.selectedUserIDs.includes(this.user.id);
    }
  },
  methods: {
    flipStatus(id) {
      this.$store.commit('TOGGLE_STATUS', id);
    },
    onCheck(id){
      const users = this.$store.state.selectedUserIDs;
      if(users.includes(id)){
        this.$store.commit('REMOVE_SELECTED_ID', id);
      } else {
        this.$store.commit('ADD_SELECTED_ID', id);
      }
    }
  }
}
</script>

<style scoped></style>