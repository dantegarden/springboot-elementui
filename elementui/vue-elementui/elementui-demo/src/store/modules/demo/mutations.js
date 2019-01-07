import {setStore, getStore} from "@/libs/mUtils";

export default {
  // TOGGLE_SIDEBAR: state => {
  //   if (state.sidebar.opened) {
  //     setStore('sidebarStatus', 1)
  //   } else {
  //     setStore('sidebarStatus', 0)
  //   }
  //   state.sidebar.opened = !state.sidebar.opened
  // },
  // ADD_VISITED_VIEWS: (state, view) => {
  //   if (state.visitedViews.some(v => v.path === view.path)) return
  //   state.visitedViews.push({name: view.name, path: view.path})
  // },
  // DEL_VISITED_VIEWS: (state, view) => {
  //   let index
  //   for (const [i, v] of state.visitedViews.entries()) {
  //     if (v.path === view.path) {
  //       index = i
  //       break
  //     }
  //   }
  //   state.visitedViews.splice(index, 1)
  // }
}
