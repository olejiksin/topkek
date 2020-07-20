import {Component} from 'react';
import React from "react";

export default class Services extends Component {
    render() {
        const {stopService, addCopyOfInstance, startService, deleteService, services} = this.props;
        let serv=null;
        if (services){
          serv = services.map((service, index) =>
            <div key={index}>
                <tr>
                    <td>{service.instanceName}</td>
                    <td>{service.instanceUrl}</td>
                    <td>{service.status}</td>
                    <td>
                        <button className={'btn'} onClick={() => addCopyOfInstance(service)}>Add copy</button>
                    </td>
                    {service.status === 'active' ?
                        <td>
                            <button className={'btn'} style={{color: 'darkred'}}
                                    onClick={() => stopService(service.instanceId)}>Stop
                            </button>
                        </td>
                        :
                        <td>
                            < button className={'btn'} style={{color: 'green'}}
                                     onClick={() => startService(service.instanceId)}>Start
                            </button>
                        </td>}
                    <td>
                        <button className={'btn'} onClick={() => deleteService(service.instanceId)}>Delete</button>
                    </td>
                </tr>
            </div>);}
        return (
            <div>
                <table className={'table'}>
                    <tbody>
                    <tr>Your active services:</tr>
                    <br/>
                    <tr>
                        <td>Microservice name</td>
                        <td>URL</td>
                        <td>Status</td>
                    </tr>
                    {serv == null ? 'Loading' : serv}
                    </tbody>
                </table>
            </div>
        );
    }
}


