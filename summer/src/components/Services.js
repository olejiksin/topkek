import {Component} from 'react';
import React from "react";

export default class Services extends Component {
    render() {
        const {stopService, addCopyOfInstance, startService, deleteService, services} = this.props;
        console.log(services);
        if (services) {
            const serv = services.map((service, index) =>
                <div key={index}>
                    {service.instance.map((ins, index) =>
                        <tr key={index}>
                            <td>{service.gitUrl}</td>
                            <td>{ins.instanceName}</td>
                            <td>{ins.instanceUrl}</td>
                            <td>{ins.status}</td>
                            <td>
                                <button className={'btn'} onClick={() => addCopyOfInstance(ins)}>Add copy</button>
                            </td>
                            {ins.status === 'active' ?
                                <td>
                                    <button className={'btn'} style={{color: 'darkred'}}
                                            onClick={() => stopService(ins.instanceId)}>Stop
                                    </button>
                                </td>
                                :
                                <td>
                                    < button className={'btn'} style={{color: 'green'}}
                                             onClick={() => startService(ins.instanceId)}>Start
                                    </button>
                                </td>}
                            <td>
                                <button className={'btn'} onClick={() => deleteService(ins.instanceId)}>Delete
                                </button>
                            </td>
                        </tr>
                    )}
                </div>)
            return (
                <div>
                    <table className={'table'}>
                        {/*<thead>*/}
                        {/*<tr>*/}
                            {/*<th>GitHub Url</th>*/}
                            {/*<th>Name</th>*/}
                            {/*<th>URL</th>*/}
                            {/*<th>Status</th>*/}
                        {/*</tr>*/}
                        {/*</thead>*/}
                        <tbody>
                        {serv}
                        </tbody>
                    </table>
                </div>
            );
        }
    }
}


