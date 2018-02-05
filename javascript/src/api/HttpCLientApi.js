import { electrodeBridge } from 'react-native-electrode-bridge';
import HttpClientRequests from './HttpClientRequests';

const REQUESTS = new HttpClientRequests(electrodeBridge);

export function requests() {
    return REQUESTS;
}


export default ({requests});


