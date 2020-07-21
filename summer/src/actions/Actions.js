import axios from 'axios';
import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE, DELETE_SERVICE,
    ERROR, LOGOUT,
    START_SERVICE,
    STOP_INSTANCE,
    SUCCESS,
    SUCCESS_AUTH
} from "../types/types";

export const logout = () => {
    // localStorage.userId = null;
    // localStorage.username = null;
    // localStorage.token = null;
    return dispatch => {
        dispatch(logOut);
    }
};


export const logIn = (username, password) => {
    localStorage.username = username;
    localStorage.services = [];
    let data = {
        login: username,
        password: password
    };
    return dispatch => {
        axios.post(`/login`, data,)
            .then((response) => {
                data.token = response.data;
                dispatch(SuccessAuth(data));
                let token = {"status": data.token.status, "userId": data.token.userId, "value": data.token.value};
                localStorage.token = ("token", JSON.stringify(token));
                localStorage.userId = data.token.userId;
            })
            .catch((error) => {
                dispatch(Error(error))
            });
    };
};

export const getServices = (userid) => {
    return dispatch => {
        let hd = JSON.parse(localStorage.token).value;
        console.log(hd);
        axios.get(`/applications/${userid}`, {headers: {Authorization: hd}})
            .then(response => {
                dispatch(SuccessActive(response.data));
                localStorage.services = response.data;
                console.log(localStorage);
            })
            .catch(error => {
                dispatch(Error(error.message))
            });
    };
};

export const addCopyOfInstance = (data) => {
    let hd = JSON.parse(localStorage.token).value;
    return dispatch => {
        axios.post(`/applications`, data, {headers: {Authorization: hd}})
            .then((response) => {
                dispatch(copyOfInstance(response.data))
            })
            .catch(error => {
                dispatch(Error(error.message));
            });
    };
};
export const addNewInstance = (git, username) => {
    let hd = JSON.parse(localStorage.token).value;
    let data = {
        gitUrl: git,
        ownerName: username,
        type: 'docker-compose'
    };
    return dispatch => {
        let id=null;
        axios.post(`/applications`, data, {headers: {Authorization: hd}})
            .then((response) => {
                console.log(response.data);
                id=response.data.id;
                dispatch(newInstance(response.data));
                setTimeout(() => {
                    axios.put(`/applications/${id}`, null,{headers: {Authorization: hd}})
                        .then((response) => {
                            // dispatch(newInstance(response.data));
                            console.log("KEKOS")
                        })
                        .catch((error) => dispatch(Error(error.message)));
                }, 1000);
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const deleteService = (instanceId) => {
    let hd = JSON.parse(localStorage.token).value;
    let data = {
        instanceId: instanceId
    }
    return dispatch => {
        axios.delete(`/applications/${instanceId}`, {headers: {Authorization: hd}})
            .then(() => {
                dispatch(deleteServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const stopService = (instanceId) => {
    let hd = JSON.parse(localStorage.token).value;
    let data = {
        instanceId: instanceId
    };
    return dispatch => {
        axios.put(`/applications/stop/${instanceId}`, null,{headers: {Authorization: hd}})
            .then(() => {
                dispatch(stopServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const startService = (instanceId) => {
    let hd = JSON.parse(localStorage.token).value;
    let data = {
        instanceId: instanceId
    };
    return dispatch => {
        axios.put(`/applications/start/${instanceId}`, null,{headers: {Authorization: hd}})
            .then(() => {
                dispatch(startServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    }
};
export const logOut = () => {
    return {
        type: LOGOUT,
        payload: {}
    }
};
export const deleteServ = (data) => {
    return {
        type: DELETE_SERVICE,
        payload: {
            ...data
        }
    }
}
export const startServ = (data) => {
    return {
        type: START_SERVICE,
        payload: {
            ...data
        }
    }
};
export const copyOfInstance = (data) => {
    return {
        type: ADD_COPY_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const newInstance = (data) => {
    return {
        type: ADD_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const stopServ = (data) => {
    return {
        type: STOP_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const SuccessAuth = (data) => {
    return {
        type: SUCCESS_AUTH,
        payload: {
            ...data
        }
    }
};
export const SuccessActive = (data) => {
    return {
        type: SUCCESS,
        payload: {
            ...data
        }
    }
};

export const Error = (error) => {
    return {
        type: ERROR,
        payload: {error}
    };
};
