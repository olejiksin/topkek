import {UPDATE_MESS, MESS_STARTED, MESS_ERROR, MESS_SUCCESS} from "../types/types";
import axios from 'axios';

export const getMess = () => {
    return dispatch => {
        dispatch(addMessStarted());
        axios.get(`/chat`)
            .then(response => {
                dispatch(getMessSuc(response.data));
            })
            .catch(error => {
                dispatch(getError(error.message))
            });
    };
};

export const sendMessages = (user, message) => {
    let data = {
        // user: user,
        message: message,
        // loading:"kekos"
    };
    console.log("data");
    console.log(data);
    data.kek="kek";
    console.log(data);
    return dispatch=>{dispatch(updateMessages(data))};
    // return dispatch => {
    //     axios.post(`/chat/${user}`, data)
    //         .then((res) => {
    //             console.log("res");
    //             console.log(res.data);
    //             dispatch(updateMessages(data));
    //         })
    //         .catch((err) => {
    //             console.log(err);
    //             dispatch(getError(err.message));
    //         });
    // };
};
export const logout = (user) => {
    return dispatch => {
        axios.delete(`/chat/${user}`)
            .catch((err) => {
                dispatch(getError(err));
            });
    }
};
export const updateMessages = (data) => {
    return {
        type: UPDATE_MESS,
        payload: {
            ...data
        }
    };
};
export const addMessStarted = () => {
    return {
        type: MESS_STARTED
    };
};
export const getMessSuc = (data) => {
    return {
        type: MESS_SUCCESS,
        payload: {
            ...data
        }
    }
};

export const getError = (error) => {
    return {
        type: MESS_ERROR,
        payload: {error}
    };
};
