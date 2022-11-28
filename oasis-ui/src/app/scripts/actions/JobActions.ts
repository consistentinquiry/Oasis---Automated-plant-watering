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