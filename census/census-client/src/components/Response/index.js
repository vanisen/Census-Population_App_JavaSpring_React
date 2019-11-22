import React from 'react';
import {Card, Alert} from 'react-bootstrap';

const Response = ({output}) => {
  console.log(output);
  return (
      <Card>
        <Card.Body>
          <Card.Title>Output</Card.Title>
          {output && output.status === 200 && output.query === 'upload'
              ? <Alert variant="success">
                  File uploaded. Database has been updated successfully.
                </Alert>
              : ''
          }
          {output && output.isAxiosError && output.query === 'upload'
              ? <Alert variant="danger">
                  Upload failed. Please check the file for duplicates.
                </Alert>
              : ''
          }
          {output && output.status === 200 && output.query !== 'upload'
              ? <Alert variant="info">
                  {output.data.result.map((r, i) => <p key={i}>{r}</p>)}
                </Alert>
              : ''
          }
        </Card.Body>
      </Card>
  )
};

export default Response;