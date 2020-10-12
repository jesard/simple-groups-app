import axios from 'axios'

const API_URL = 'http://localhost:8080'

class GroupsDataService {

    retrieveAllGroups() {
        return axios.get(`${API_URL}/groups`);
    }

    retrieveGroup(id) {
        return axios.get(`${API_URL}/groups/${id}`);
    }

	insertGroup(number) {
		return axios.post(`${API_URL}/groups`, {number});
	}

	insertStudent(name, groupId) {
    	return axios.post(`${API_URL}/groups/${groupId}/students`, {name});
	}

	deleteStudent(groupId, studentId) {
		return axios.delete(`${API_URL}/groups/${groupId}/students/${studentId}`);
	}



}

export default new GroupsDataService()