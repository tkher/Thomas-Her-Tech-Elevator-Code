import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/portfolio',
    name: 'portfolio',
    component: PortfolioView
  }

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
