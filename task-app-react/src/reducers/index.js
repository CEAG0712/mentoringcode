import { combineReducers } from "redux";
//import taskReducer from "./taskReducer";
import columnReducer from "./columnReducer";

export default combineReducers({
  //task: taskReducer,
  column: columnReducer
});
