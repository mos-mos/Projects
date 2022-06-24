import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "./components/Login";
import Register from "./components/register";

Vue.use(VueRouter);

const routes=[
  {path : '/login', component:Login},
  {path : '/register', component: Register}
]
const router = new VueRouter({
  routes
})

export default router;
