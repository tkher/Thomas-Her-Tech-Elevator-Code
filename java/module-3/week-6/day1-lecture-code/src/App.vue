<template>
  <header>
    <!-- 1-way Binding -->
    <h1>Data description: {{ description }}</h1>
    <h1>score: {{ score + 1 }}</h1>
    <h1>rectangle area: {{ rectangleArea }}</h1>

    <hr />

    <!-- V-MODEL, 2-way binding -->
    <h1>V-MODEL</h1>
    <label for="width">Width</label>
    <input type="text" name="" id="width" v-model="width">
    <br />
    <label for="min-id">minimum id</label>
    <input type="text" name="" id="mind-id" />

    <hr />

    <!-- V-FOR, iterating over range, object, or array -->
    <h1>V-FOR</h1>
    <ul>
      <!-- iterating 5 number of times -->
      <!-- <li v-for="(n, index) in 5"> -->

      <!-- iterating over an object -->
      <!-- <li v-for="(value, key, index) in obj"> -->

      <!-- iterating over an array -->
      <!-- <li v-for="eachReview in filteredReviews" v-bind:key="eachReview.id"> -->

      <!-- </li> -->
    </ul>

    <hr />

    <!-- V-BIND, binding javascript to attributes -->
    <h1>V-BIND</h1>

    <!-- V-BIND class attributes -->
    <label for="chkbox">special area display</label>
    <input type="checkbox" name="" id="chkbox" />

    <hr />

    <!-- V-ON, V-IF/V-SHOW, conditionally hide elements -->
    <h1>V-ON, V-IF/V-SHOW</h1>
    <div>
      <button>show form</button>
      <form action="" method="get">
        <label for="new-id">new id</label>
        <input type="text" name="" id="new-id" />
        <label for="min-id">reviewer</label>
        <input type="text" name="" id="min-id" />
        <button type="submit">Add new Review</button>
      </form>
    </div>
  </header>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import TheWelcome from './components/TheWelcome.vue'

export default {
  name: "my-cool-app",
  components: {},
  data() {
    /*
     * Component data goes here
     */
    return {
      description: 'One-Way Binding Demo',
      score: 42,
      width: 5,
      height: 5
    };
  },
  computed: {
    /*
     * Derived properties go here
     */
    rectangleArea(){
      // const width = 2;
      return this.width * this.height;
    }
  },
  methods: {
    /*
     * methods go here
     */
  }
};
</script>

<style scoped>
.special {
  color: green;
  font-weight: bold;
}

hr {
  margin: 20px 0;
}

header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
