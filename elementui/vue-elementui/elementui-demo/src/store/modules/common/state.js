import {getStore} from "@/libs/mUtils";

export default {
  sidebar: {
    opened: !+getStore('sidebarStatus')
  },
  visitedViews: []
}
