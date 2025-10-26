import React from 'react';
import { Statistic, Grid } from 'semantic-ui-react';
import { Company } from '../services/api';

interface StatisticsProps {
  companies: Company[];
}

export const Statistics: React.FC<StatisticsProps> = ({ companies }) => {
  const ukCount = companies.filter(c => c.country === 'UK').length;
  const franceCount = companies.filter(c => c.country === 'FRANCE').length;
  const germanyCount = companies.filter(c => c.country === 'GERMANY').length;
  const activeCount = companies.filter(c => c.status === 'ACTIVE').length;

  return (
    <Grid columns={4} stackable>
      <Grid.Column>
        <Statistic color='blue'>
          <Statistic.Value>{companies.length}</Statistic.Value>
          <Statistic.Label>Total Companies</Statistic.Label>
        </Statistic>
      </Grid.Column>
      <Grid.Column>
        <Statistic color='green'>
          <Statistic.Value>{activeCount}</Statistic.Value>
          <Statistic.Label>Active</Statistic.Label>
        </Statistic>
      </Grid.Column>
      <Grid.Column>
        <Statistic color='red'>
          <Statistic.Value>{ukCount}</Statistic.Value>
          <Statistic.Label>
            <i className="gb flag"></i> UK
          </Statistic.Label>
        </Statistic>
      </Grid.Column>
      <Grid.Column>
        <Statistic color='teal'>
          <Statistic.Value>{franceCount}</Statistic.Value>
          <Statistic.Label>
            <i className="fr flag"></i> France
          </Statistic.Label>
        </Statistic>
      </Grid.Column>
    </Grid>
  );
};