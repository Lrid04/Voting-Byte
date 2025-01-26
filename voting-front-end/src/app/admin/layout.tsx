import Navbar from '../ui/navbar'
 
export default function Layout({
    children,
  }: Readonly<{
    children: React.ReactNode;
  }>){
  return (
    <>
      <Navbar />
      <main>{children}</main>
    </>
  )
}