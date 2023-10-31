import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      nextUserId: 7,
      selectedUserIDs: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ]
    },
    mutations: {
      INCREMENT_NEXT_USER_ID(state){
        state.nextUserId += 1;
      },
      ADD_USER(state, newUserObj){
        state.users.push(newUserObj);
      },
      REMOVE_SELECTED_ID(state, id){
        state.selectedUserIDs = state.selectedUserIDs.filter(eachId => eachId != id);
      },
      ADD_SELECTED_ID(state, id){
        state.selectedUserIDs.push(id);
      },
      CLEAR_SELECTED_IDS(state){
        state.selectedUserIDs = [];
      },
      SELECT_ALL_IDS(state, isChecked){
        state.selectedUserIDs = isChecked ? state.users.map(eachUser => eachUser.id) : [];
      },
      TOGGLE_STATUS(state, userId) {
        const index = findUserById(state, userId);
        state.users[index].status =
          state.users[index].status === "Active" ? "Inactive" : "Active";
      },
      DELETE_SELECTED_USERS(state){
        state.selectedUserIDs.forEach(id => {
          state.users = state.users.filter(eachUser => eachUser.id != id);
        });
        state.selectedUserIDs = [];
      },
      ACTIVATE_SELECTED_USERS(state){
        state.selectedUserIDs.forEach(id => {
          state.users[findUserById(state, id)].status = 'Active';
        });
        state.selectedUserIDs = [];
      },
      DEACTIVATE_SELECTED_USERS(state){
        state.selectedUserIDs.forEach(id => {
          state.users[findUserById(state, id)].status = 'Inactive';
        });
        state.selectedUserIDs = [];
      },
      SET_FILTER_FIRST_NAME(state, newFirstName) {
        state.filter.firstName = newFirstName;
      },
      SET_FILTER_LAST_NAME(state, newLastName) {
        state.filter.lastName = newLastName;
      },
      SET_FILTER_USERNAME(state, newUsername) {
        state.filter.username = newUsername;
      },
      SET_FILTER_EMAIL(state, newEmail){
        state.filter.emailAddress = newEmail;
      },
      SET_FILTER_STATUS(state, newStatus){
        state.filter.status = newStatus;
      },
    },
    actions: {},
    modules: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  })
}

const findUserById = (state, userIdToFind) => {
  return state.users.findIndex((user) => user.id == userIdToFind);
}
