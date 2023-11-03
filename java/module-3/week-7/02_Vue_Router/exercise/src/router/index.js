import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import MyBooksView from '../views/MyBooksView.vue';
import NewBookView from '../views/NewBookView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooksView
  },
  {
    path: '/addBook',
    name: 'add-book',
    component: NewBookView
  }

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
