import axios from "axios";
import { GET_ALL_TASKS } from "./ActionTypes";

export const getAllTasks = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/board");
  dispatch({
    type: GET_ALL_TASKS,
    payload: res.data
  });
};
