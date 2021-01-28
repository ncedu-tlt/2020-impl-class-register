import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import Register from './views/Register.vue';
import Schedule from "@/views/Schedule";
import HomeWork from "@/views/HomeWork";
import Billboard from "@/views/Billboard";
import FindStudent from "@/views/FindStudent";
import Chat from "@/views/Chat";

Vue.use(Router);

export const router = new Router({
  routes: [
    {
      path: '/',
      name: '/home',
      component: Home
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/schedule',
      component: Schedule
    },
    {
      path: '/homework',
      component: HomeWork
    },
    {
      path: '/billboard',
      component: Billboard
    },
    {
      path: '/findStudent',
      component: FindStudent
    },
    {
      path: '/chat',
      component: Chat
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/profile',
      name: 'profile',
      // lazy-loaded
      component: () => import('./views/Profile.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      // lazy-loaded
      component: () => import('./views/BoardAdmin.vue')
    },
    {
      path: '/mod',
      name: 'moderator',
      // lazy-loaded
      component: () => import('./views/BoardModerator.vue')
    },
    {
      path: '/user',
      name: 'user',
      // lazy-loaded
      component: () => import('./views/BoardUser.vue')
    },
    {
      path: '/schedule',
      name: 'schedule',
      // lazy-loaded
      component: () => import('./views/Schedule.vue')
    },
    {
      path: '/homework',
      name: 'homework',
      // lazy-loaded
      component: () => import('./views/HomeWork.vue')
    },
    {
      path: '/billboard',
      name: 'billboard',
      // lazy-loaded
      component: () => import('./views/Billboard.vue')
    },
    {
      path: '/findStudent',
      name: 'findStudent',
      // lazy-loaded
      component: () => import('./views/FindStudent.vue')
    },
    {
      path: '/chat',
      name: 'chat',
      // lazy-loaded
      component: () => import('./views/Chat.vue')
    }
  ]
});

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/home'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('/login');
  } else {
    next();
  }
});
