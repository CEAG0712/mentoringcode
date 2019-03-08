import axios from "axios";
import { GET_ALL_COLUMNS } from "./ActionTypes";

export const getAllColumns = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/projectboard");
  dispatch({
    type: GET_ALL_COLUMNS,
    payload: res.data
  });
};
