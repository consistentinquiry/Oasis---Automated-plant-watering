import axios from "axios";

export const CREATE_JOB = "CREATE_JOB";
export const UPDATE_JOB = "UPDATE_JOB";
export const DELETE_JOB = "DELETE_JOB";

export const GET_JOB = "GET_JOB";
export const GET_ALL_JOBS = "GET_ALL_JOBS";

const JOB_ENDPOINT = "jobs"

const jobActionCreator = (jobActionType: any) => {
    return {
        type: jobActionType,
    }
}

export const fetchJobs = () => {
    console.log("Dispatching async action...");
    return function (dispatch: any) {
        axios.get('http://localhost:8080/jobs').then(
            response => {
                console.log(response)
                // dunno quite what this is yet
                dispatch({type: GET_JOB, payload: response.data})
            }
        ).catch(error => {
            // error.message is the error description
        })
    }
}