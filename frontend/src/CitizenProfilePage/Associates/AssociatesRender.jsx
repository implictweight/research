import CallRecordsTable from './CallRecordsTable';
import Colleagues from './Colleagues';

const AssociatesRender = ({ data }) => {
  const { colleagues } = data;
  const called = data.callRecords;
  const RenderColleagues = colleagues.map((d) => <Colleagues data={d} />);
  const RenderCallRecords = called.map((d) => <CallRecordsTable data={d} />);

  return (
    <>
      <div>
        Recent Call History
      </div>
      <table className="table" id="callRecordsTable">
        <thead>
          <tr>
            <th scope="col">Time Stamp</th>
            <th scope="col">Receiver</th>
            <th scope="col">Receiver Phone Number</th>
            <th scope="col">View Receiver Bio</th>
          </tr>
        </thead>
        { RenderCallRecords }
      </table>
      <br />
      <div>
        Business Name:
        {' '}
        {data.businessName}
        <br />
        Business Address:
        {' '}
        {data.businessAddress}
        <br />
      </div>
      <table className="table" id="colleaguesTable">
        <thead>
          <tr>
            <th scope="col">Colleague</th>
            <th scope="col">Date of Birth</th>
          </tr>
        </thead>
        { RenderColleagues }
      </table>
    </>
  );
};

export default AssociatesRender;
