import { electrodeBridge } from 'react-native-electrode-bridge';
import HttpCLientRequests from './HttpCLientRequests';

const REQUESTS = new HttpCLientRequests(electrodeBridge);

export function requests() {
    return REQUESTS;
}


export default ({requests});


