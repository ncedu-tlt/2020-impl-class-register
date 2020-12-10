import Vue from 'vue';
import Router from 'vue-router';
import MainPage from "@/views/MainPage";
import ProfilePage from "@/views/ProfilePage";

Vue.use(Router);

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'main',
            component: MainPage,
            meta: {
                scrollToTopOnLeave: true
            }
        },

        {
            path: '/profile',
            name: 'profile',
            component: ProfilePage,
            meta: {
                scrollToTopOnLeave: true
            }
        }
    ]
});

export default router;
