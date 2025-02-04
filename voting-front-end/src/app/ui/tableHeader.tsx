import { Document, Page, Text, View } from "@react-pdf/renderer";

export default function TableDoc() {
  return (
    <Document>
      <Page>
        <View >
            
          <View>
            <Text>Name</Text>
          </View>

          <View>
            <Text>School</Text>
          </View>

          <View>
            <Text>Division</Text>
          </View>

          <View>
            <Text>Pin</Text>
          </View>

        </View>
      </Page>
    </Document>
  );
}
